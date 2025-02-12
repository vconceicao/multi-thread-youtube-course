# Multi-Threading Exercises 🚀  

A collection of exercises and examples focused on multi-threading in Java, designed to enhance your understanding of concurrent programming. These exercises cover key concepts such as thread synchronization, locks, thread pools, and parallel processing.  

## 🏗 Project Structure  

```
📂 multi-thread-exercises
 ├── 📁 src
 │   ├── 📁 classesatomicas         # Fundamental threading concepts
 │   ├── 📁 countdownlatch # Locks, synchronized blocks, atomic variables
 │   ├── 📁 cyclicbarrier     # Using ExecutorService and ForkJoinPool
 │   ├── 📁 executors
 │   ├── 📁 locks
 │   ├── 📁 semaphore
 │   ├── 📁 synchrounousqueue
 │   ├── 📁 synchronized
 │   ├── 📁 thread
 │   ├── 📁 volatile       # Parallel computing with Streams and CompletableFuture
 │   └── 📁 locks      # Deadlocks, thread safety, and performance tuning
 ├── 📄 README.md          # This file

```

## 📌 Topics Covered  

- **Creating Threads**: `Thread` vs `Runnable` vs `Callable`  
- **Thread Synchronization**: `synchronized`, `ReentrantLock`, `Atomic Variables`  
- **Thread Pools**: `ExecutorService`, `ForkJoinPool`, `ScheduledThreadPoolExecutor`  
- **Parallel Streams**: Leveraging Java Streams for parallel computation  
- **CompletableFuture**: Asynchronous programming  
- **Deadlocks & Race Conditions**: How to detect and prevent them  
- **Performance Considerations**: Best practices for writing efficient multi-threaded code  

## 🛠️ Requirements  

- **Java 17+**  
- **Maven or Gradle** (optional for dependency management)  

## 🚀 Getting Started  

Clone the repository:  

```bash
git clone https://github.com/your-repo/multi-thread-exercises.git
cd multi-thread-exercises
```

Run the exercises using:  

```bash
mvn test   # If using Maven
gradle test  # If using Gradle
```

Or execute individual Java files from your IDE.  

## ✅ How to Contribute  

1. Fork the repository  
2. Create a new branch: `feature/new-exercise`  
3. Commit your changes:  
   ```bash
   git commit -m "Added a new exercise on CompletableFuture"
   ```
4. Push to your branch and create a Pull Request  

## 📝 Resources  

- [Java Concurrency Documentation](https://docs.oracle.com/javase/tutorial/essential/concurrency/)  
- [Java Threading Best Practices](https://www.baeldung.com/java-concurrency)  

## 📜 License  

This project is licensed under the MIT License.  

---

Let me know if you need any modifications! 🚀
