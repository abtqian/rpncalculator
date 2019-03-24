# rpncalculator
[![GitHub release](https://img.shields.io/badge/release-download-orange.svg)](https://github.com/abtqian/rpncalculator/releases/tag/v1.0.0)
[![Build Status](https://travis-ci.org/abtqian/rpncalculator.svg?branch=master)](https://travis-ci.org/abtqian/rpncalculator)
[![Coverage Status](https://coveralls.io/repos/github/abtqian/rpncalculator/badge.svg)](https://coveralls.io/github/abtqian/rpncalculator)

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
