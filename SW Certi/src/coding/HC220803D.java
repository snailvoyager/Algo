package coding;

public class HC220803D {}

/*
import org.springframework.context.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

    @Configuration
    public class BookSearch {
        @Bean
        public BookRepository bookRepository() {
            return new BookRepository();
        }

        @Bean
        public BookSearchService bookSearchService() {
            return new BookSearchService();
        }

        @Bean
        public RecommendationService recommendationService() {
            return new RecommendationService();
        }
    }

    @Component
    class RecommendationService {
        @Autowired
        public BookRepository repository;

        public String recommendBook() {
            return repository.getBooks().get(0);
        }
    }
*/

