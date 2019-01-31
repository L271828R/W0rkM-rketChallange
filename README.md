# Project Title

Code Challange for workmarket

## Getting Started


### Prerequisites

Please have JAVA 8, Maven and GIT installed

There is also a configuration file found at src/main/resource/properties.json
Kindly configure the location of your Chrome driver there.


### Installing

Running Maven's validate will download all the needed dependencies.

```
mvn validate
```

### Running Challenge 1 (happy path)

```
mvn -Dtest=TestSignUpPage#happyPath test
```

### Running Challenge 2
```
mvn -Dtest=TestSearchChallange test
```

### Running failing tests from Challange 1
```
mvn -Dtest=TestSignUpFailing#largeFirstName test
mvn -Dtest=TestSignUpFailing#digitsInFirstNameLastName test
```

