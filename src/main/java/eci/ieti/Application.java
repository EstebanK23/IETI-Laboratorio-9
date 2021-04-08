package eci.ieti;

import eci.ieti.data.CustomerRepository;
import eci.ieti.data.ProductRepository;
import eci.ieti.data.TodoRepository;
import eci.ieti.data.UserRepository;
import eci.ieti.data.model.Customer;
import eci.ieti.data.model.Product;

import eci.ieti.data.model.Todo;
import eci.ieti.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TodoRepository todoRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");

        customerRepository.deleteAll();

        customerRepository.save(new Customer("Alice", "Smith"));
        customerRepository.save(new Customer("Bob", "Marley"));
        customerRepository.save(new Customer("Jimmy", "Page"));
        customerRepository.save(new Customer("Freddy", "Mercury"));
        customerRepository.save(new Customer("Michael", "Jackson"));

        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        
        customerRepository.findAll().stream().forEach(System.out::println);
        System.out.println();
        
        productRepository.deleteAll();

        productRepository.save(new Product(1L, "Samsung S8", "All new mobile phone Samsung S8"));
        productRepository.save(new Product(2L, "Samsung S8 plus", "All new mobile phone Samsung S8 plus"));
        productRepository.save(new Product(3L, "Samsung S9", "All new mobile phone Samsung S9"));
        productRepository.save(new Product(4L, "Samsung S9 plus", "All new mobile phone Samsung S9 plus"));
        productRepository.save(new Product(5L, "Samsung S10", "All new mobile phone Samsung S10"));
        productRepository.save(new Product(6L, "Samsung S10 plus", "All new mobile phone Samsung S10 plus"));
        productRepository.save(new Product(7L, "Samsung S20", "All new mobile phone Samsung S20"));
        productRepository.save(new Product(8L, "Samsung S20 plus", "All new mobile phone Samsung S20 plus"));
        productRepository.save(new Product(9L, "Samsung S20 ultra", "All new mobile phone Samsung S20 ultra"));
        
        System.out.println("Paginated search of products by criteria:");
        System.out.println("-------------------------------");
        
        productRepository.findByDescriptionContaining("plus", PageRequest.of(0, 2)).stream()
        	.forEach(System.out::println);
   
        System.out.println();

        userRepository.deleteAll();

        userRepository.save(new User("1","Esteban","esteban@gmail.com"));
        userRepository.save(new User("2","David","david@gmail.com"));
        userRepository.save(new User("3","Julian","julian@gmail.com"));
        userRepository.save(new User("4","Daniel","daniel@gmail.com"));
        userRepository.save(new User("5","Brayan","brayan@gmail.com"));
        userRepository.save(new User("6","Maria","maria@gmail.com"));
        userRepository.save(new User("7","Paula","paula@gmail.com"));
        userRepository.save(new User("8","Cristian","cristian@gmail.com"));
        userRepository.save(new User("9","Andrea","andrea@gmail.com"));
        userRepository.save(new User("10","Federico","federico@gmail.com"));

        todoRepository.deleteAll();

        todoRepository.save(new Todo("todo1",5,new Date(121,1,1),"esteban@gmail.com","expired"));
        todoRepository.save(new Todo("todo2",3,new Date(121,1,2),"esteban1@gmail.com","EnCurso"));
        todoRepository.save(new Todo("todo3",3,new Date(121,1,3),"esteban2@gmail.com","EnCurso"));
        todoRepository.save(new Todo("todo4",3,new Date(121,1,4),"esteban3@gmail.com","EnCurso"));
        todoRepository.save(new Todo("todo5",3,new Date(121,1,5),"esteban4@gmail.com","EnCurso"));
        todoRepository.save(new Todo("todo6",3,new Date(121,1,6),"esteban5@gmail.com","EnCurso"));
        todoRepository.save(new Todo("todo7",5,new Date(121,1,7),"esteban@gmail.com","EnCurso"));
        todoRepository.save(new Todo("todo8",3,new Date(121,1,8),"esteban7@gmail.com","EnCurso"));
        todoRepository.save(new Todo("todo9",3,new Date(121,1,9),"esteban8@gmail.com","EnCurso"));
        todoRepository.save(new Todo("todo10",3,new Date(121,1,10),"esteban9@gmail.com","EnCurso"));
        todoRepository.save(new Todo("todo11",3,new Date(121,1,11),"esteban10@gmail.com","EnCurso"));
        todoRepository.save(new Todo("todo12",3,new Date(121,1,12),"esteban11@gmail.com","expired"));
        todoRepository.save(new Todo("todo13",5,new Date(121,1,13),"esteban12@gmail.com","EnCurso"));
        todoRepository.save(new Todo("todo14",3,new Date(121,1,14),"esteban13@gmail.com","EnCurso"));
        todoRepository.save(new Todo("todo15",3,new Date(121,1,15),"esteban@gmail.com","EnCurso"));
        todoRepository.save(new Todo("todo16",3,new Date(121,1,16),"esteban15@gmail.com","EnCurso"));
        todoRepository.save(new Todo("todo17",3,new Date(121,1,17),"esteban16@gmail.com","EnCurso"));
        todoRepository.save(new Todo("todo18",3,new Date(121,1,18),"esteban17@gmail.com","EnCurso"));
        todoRepository.save(new Todo("todo19",3,new Date(121,1,19),"esteban18@gmail.com","expired"));
        todoRepository.save(new Todo("todo20",3,new Date(121,1,20),"esteban19@gmail.com","EnCurso"));
        todoRepository.save(new Todo("todo21",5,new Date(121,1,21),"esteban20@gmail.com","EnCurso"));
        todoRepository.save(new Todo("todo22",3,new Date(121,1,22),"esteban21@gmail.com","EnCurso"));
        todoRepository.save(new Todo("todo23",3,new Date(121,1,23),"esteban22@gmail.com","EnCurso"));
        todoRepository.save(new Todo("todo24",3,new Date(121,1,24),"esteban23@gmail.com","EnCurso"));
        todoRepository.save(new Todo("todo25",3,new Date(121,1,25),"esteban24@gmail.com","EnCurso"));

        Query query = new Query();
        query.addCriteria(Criteria.where("dueDate").lt(new Date(121,1,12)));
        List<Todo> todos = mongoOperation.find(query, Todo.class);
        for (Todo x:todos){
            System.out.println(x.toString());
        }

        Query query1 = new Query();
        query1.addCriteria(Criteria.where("responsible").is("esteban@gmail.com").and("priority").gt(4));
        List<Todo> todos1 = mongoOperation.find(query1, Todo.class);
        for (Todo x: todos1){
            System.out.println(x.toString());
        }
        
    }

}