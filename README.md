# Code Challenge for workmarket

## Getting Started


### Prerequisites

Please have JAVA 8, Maven and GIT installed

The tests use Selenium and target the Chrome Driver.

There is also a configuration file found at src/main/resources/properties.json
Kindly configure the location of your Chrome driver there.

If you have questions on how to obtain a Chrome driver kindly consult the following:

http://chromedriver.chromium.org/downloads
https://www.kenst.com/2015/03/installing-chromedriver-on-mac-osx/
https://splinter.readthedocs.io/en/0.1/setup-chrome.html


### Installing

Running Maven's validate will download all the needed dependencies.

```
mvn validate
```

### Running Challenge 1 (happy path)

```
mvn -Dtest=TestSignUpPage#happyPath test
```
If the above has a compilation failure. You may need to
simply run it again.

### Running Challenge 2
```
mvn -Dtest=TestSearchChallange test
```

### Running failing tests from Challange 1
```
mvn -Dtest=TestSignUpFailing#largeFirstName test
mvn -Dtest=TestSignUpFailing#digitsInFirstNameLastName test
```


