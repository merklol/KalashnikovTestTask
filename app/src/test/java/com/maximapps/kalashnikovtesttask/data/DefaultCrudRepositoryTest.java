package com.maximapps.kalashnikovtesttask.data;

import static com.maximapps.kalashnikovtesttask.LiveDataTestUtil.getOrAwaitValue;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;

import com.maximapps.kalashnikovtesttask.data.db.AppDao;
import com.maximapps.kalashnikovtesttask.data.db.models.AuthorEntity;
import com.maximapps.kalashnikovtesttask.data.db.models.BookEntity;
import com.maximapps.kalashnikovtesttask.domain.CrudRepository;
import com.maximapps.kalashnikovtesttask.domain.models.Book;
import com.maximapps.kalashnikovtesttask.domain.models.BookDetails;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(JUnit4.class)
public class DefaultCrudRepositoryTest {
    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();
    @Mock
    private AppDao dao;
    private final Date date = new Date();
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void return_transformed_livedata_when_fetch_new_books() throws InterruptedException {
        List<BookEntity> fakeList = List.of(new TestBookEntityBuilder().build());
        when(dao.fetchBooks()).thenReturn(new MutableLiveData<>(fakeList));
        CrudRepository repository = new DefaultCrudRepository(dao, executorService);
        List<Book> expected = List.of(new Book(0, "Zenith", "Description"));
        assertEquals(expected, getOrAwaitValue(repository.fetchBooks()));
    }

    @Test
    public void return_transformed_livedata_with_selected_book_details() throws InterruptedException {
        BookEntity fakeBookEntity = new TestBookEntityBuilder().build();
        AuthorEntity fakeAuthorEntity = new TestAuthorEntityBuilder().birthDate(date).build();
        when(dao.fetchBookById(anyInt())).thenReturn(new MutableLiveData<>(fakeBookEntity));
        when(dao.findAuthorById(anyInt())).thenReturn(new MutableLiveData<>(fakeAuthorEntity));

        CrudRepository repository = new DefaultCrudRepository(dao, executorService);

        BookDetails details = new TestBookDetailsBuilder().birthDate(date).build();
        assertEquals(details, getOrAwaitValue(repository.fetchBookDetailsById(0)));
    }

    @Test
    public void return_transformed_livedata_with_empty_book_details_when_wrong_id() throws InterruptedException {
        BookEntity fakeBookEntity = new TestBookEntityBuilder().build();
        AuthorEntity fakeAuthorEntity = new TestAuthorEntityBuilder().build();
        when(dao.fetchBookById(0)).thenReturn(new MutableLiveData<>(fakeBookEntity));
        when(dao.findAuthorById(0)).thenReturn(new MutableLiveData<>(fakeAuthorEntity));

        CrudRepository repository = new DefaultCrudRepository(dao, executorService);

        BookDetails expected = getOrAwaitValue(repository.fetchBookDetailsById(1));
        assertThat(BookDetails.empty(), instanceOf(expected.getClass()));
    }

    @Test
    public void when_updateBookDescriptionById_called_verified() {
        doNothing().when(dao).updateBookDescriptionById(anyInt(), anyString());
        CrudRepository repository = new DefaultCrudRepository(dao, executorService);
        repository.updateBookDescriptionById(0, "");
        verify(dao, atLeast(1)).updateBookDescriptionById(anyInt(), anyString());
    }
}