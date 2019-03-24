# rpncalculator

This is a RPN calculator written in JAVA.

## Build project
```
mvn clean package
```

## Run project
```
./run.sh
```

## Support Operations
```
+ - * / sqrt clear undo
```

## Example
```
> ./run.sh 
RPN caculator is running!
You can input '\q' or 'exit' to stop
> 1 2 3 4
stack: 1 2 3 4 
> -    
stack: 1 2 -1 
> -
stack: 1 3 
> * 3 sqrt
stack: 3 1.7320508075
> undo undo
stack: 3 
```
