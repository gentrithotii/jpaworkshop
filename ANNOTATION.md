# 🌱 Core Spring Annotations

| Annotation            | Description                                                | Example                                     |
| :-------------------- | :--------------------------------------------------------- | :------------------------------------------ |
| **`@Component`** | Marks a class as a Spring-managed component.               | `@Component`<br>`public class MyService {}` |
| **`@Service`** | Specialization of `@Component` for service classes.        | `@Service`<br>`public class UserService {}` |
| **`@Repository`** | Indicates a DAO or repository class. Enables exception translation. | `@Repository`<br>`public class UserRepository {}` |
| **`@Controller`** | Marks a class as a Spring MVC controller (used with views). | `@Controller`<br>`public class HomeController {}` |
| **`@RestController`** | `@Controller` + `@ResponseBody` (used in REST APIs).       | `@RestController`<br>`public class ApiController {}` |
| **`@Configuration`** | Declares a class as a source of bean definitions.          | `@Configuration`<br>`public class AppConfig {}` |
| **`@Bean`** | Declares a method that returns a Spring bean.              | `@Bean`<br>`public MyBean myBean() { return new MyBean(); }` |

---

# 🚀 Spring Boot Specific

| Annotation            | Description                                                | Example                                     |
| :-------------------- | :--------------------------------------------------------- | :------------------------------------------ |
| **`@SpringBootApplication`** | Combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`. Main entry point. | `@SpringBootApplication`<br>`public class MyApp {}` |
| **`@EnableAutoConfiguration`** | Enables Spring Boot auto-configuration. Mostly used inside `@SpringBootApplication` | |
| **`@ComponentScan`** | Tells Spring to scan for `@Component` classes.             | `@ComponentScan("com.myapp")`               |

---

# 🧩 Dependency Injection

| Annotation  | Description                     | Example                             |
| :---------- | :------------------------------ | :---------------------------------- |
| **`@Autowired`** | Injects a bean by type.         | `@Autowired`<br>`private UserService userService;` |
| **`@Qualifier`** | Used with `@Autowired` to specify the bean name. | `@Autowired`<br>`@Qualifier("myBean")`     |

---

# 🌐 Web / REST

| Annotation                 | Description                                    | Example                                                        |
| :------------------------- | :--------------------------------------------- | :------------------------------------------------------------- |
| **`@GetMapping`, `@PostMapping`, etc.** | Shorthand for request mapping with method type. | `@GetMapping("/users")`                                        |
| **`@RequestMapping`** | Maps HTTP requests to handler methods.         | `@RequestMapping(value="/users", method=GET)`                  |
| **`@RequestParam`** | Extracts query params.                         | `@GetMapping`<br>`public String hello(@RequestParam String name)` |
| **`@PathVariable`** | Extracts path variables.                       | `/user/{id}` → `@PathVariable Long id`                         |
| **`@RequestBody`** | Binds request body to a method param.          | `public Response create(@RequestBody User user)`               |
| **`@ResponseBody`** | Returns JSON/XML directly. Used in `@RestController`. | `@ResponseBody`<br>`public User getUser()`                    |

---

# 📦 Data / JPA

| Annotation     | Description                        | Example                                     |
| :------------- | :--------------------------------- | :------------------------------------------ |
| **`@Entity`** | Marks a class as a JPA entity.     | `@Entity`<br>`public class User {}`        |
| **`@Id`** | Marks the primary key.             | `@Id private Long id;`                     |
| **`@GeneratedValue`** | Auto-generates primary key.        | `@GeneratedValue(strategy = GenerationType.IDENTITY)` |
| **`@Table`** | Maps the entity to a DB table.     | `@Table(name = "users")`                   |
| **`@Column`** | Maps a field to a DB column.       | `@Column(name = "email")`                  |

---

# 🧪 Testing

| Annotation       | Description                                                | Example                                     |
| :--------------- | :--------------------------------------------------------- | :------------------------------------------ |
| **`@SpringBootTest`** | Loads the full Spring Boot context for integration tests.  | `@SpringBootTest`                           |
| **`@MockBean`** | Mocks a Spring bean in tests.                              | `@MockBean`<br>`private UserService userService;` |

---

# ✅ Validation

| Annotation                 | Description                          | Example                                                        |
| :------------------------- | :----------------------------------- | :------------------------------------------------------------- |
| **`@Valid` / `@Validated`** | Triggers validation on request data. | `public Response register(@Valid @RequestBody UserDto dto)`    |
| **`@NotNull`, `@Size`, `@Email`, etc.** | Bean validation annotations.         | `@NotNull`<br>`@Size(min=3)`                                  |

---

# 🧵 Others

| Annotation    | Description                            | Example                                     |
| :------------ | :------------------------------------- | :------------------------------------------ |
| **`@Value`** | Injects values from properties files.  | `@Value("${app.name}")`                    |
| **`@Profile`** | Specifies the profile a bean belongs to. | `@Profile("dev")`                           |
| **`@Scheduled`** | Schedules tasks to run periodically.   | `@Scheduled(fixedRate = 5000)`             |