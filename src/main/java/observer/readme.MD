### Observer design pattern
#### i) [Link1](https://www.digitalocean.com/community/tutorials/observer-design-pattern-in-java)
#### ii) [LInk2](https://www.geeksforgeeks.org/observer-method-design-pattern-in-java/) (simple version)

#### Notes:
According to GoF, observer design pattern intent is;
```agsl
Define a one-to-many dependency between objects so that when one object changes state,
 all its dependents are notified and updated automatically.
```
#### Two types -> PUSH and PULL 
Subject -> state to be changed, list of observers , register , unregister , notify,
Observer -> method to set the object to watch , another method that will be used by Subject to notify

##### Java provides inbuilt platform for implementing Observer pattern through java.util.Observable class and java.util.Observer interface
However , it’s not widely used because the implementation is really simple
