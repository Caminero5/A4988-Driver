# A4988 Java Driver
Before developing I would ask you please donate to help support me and the open
source community, I spend a couple of weeks researching and developing this software
and would appreciate monetary compensation. If you're also a student just trying to learn
and just using this software for personal reasons please don't donate. If you're using this
commercially I would greatly appreciate the compensation.

-Daniel Caminero

## [Donate Here](https://www.paypal.com/donate/?hosted_button_id=JJPCAWFNDKNZS)

<form action="https://www.paypal.com/donate" method="post" target="_top">
<input type="hidden" name="hosted_button_id" value="JJPCAWFNDKNZS" />
<input type="image" src="https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif" border="0" name="submit" title="PayPal - The safer, easier way to pay online!" alt="Donate with PayPal button" />

**This driver is to be able to control a A4988 stepper motor driver in java.**
## Installation

A4988 Driver jar is located in `target/A4988Driver-VERSION.jar`

### Python Dependencies
First you need to install our python scripts, these uses already built in libs so no pip installing
is needed unless for some reason you don't have `RPi`

First run this command

`wget https://install.swiftpcb.tech/1.2.1.zip`

This is to download the zip file with all the python scripts, replace '1.2.1' with the version you have
for this example we will go with 1.2.1

Then run this command

`unzip PATH/TO/ZIP/1.2.1.zip -d /home/pi`

after this you need to install the correct maven dependencies
### Maven

Include these dependencies to your project to have everything working

```xml
<dependencies>
    <dependency>
        <groupId>commons-lang</groupId>
        <artifactId>commons-lang</artifactId>
        <version>2.1</version>
    </dependency>
    <dependency>
        <groupId>org.codehaus.plexus</groupId>
        <artifactId>plexus-utils</artifactId>
        <version>1.1</version>
    </dependency>
    <dependency>
        <groupId>com.googlecode.json-simple</groupId>
        <artifactId>json-simple</artifactId>
        <version>1.1.1</version>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>${slf4j.version}</version>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-simple</artifactId>
        <version>${slf4j.version}</version>
    </dependency>
    <dependency>
        <groupId>org.xerial</groupId>
        <artifactId>sqlite-jdbc</artifactId>
        <version>3.36.0.3</version>
    </dependency>
</dependencies>
```

after adding these dependencies you need to include our `A4988Driver.jar` into your project
the jar might be called something different depending on the version you have

### Gradle or standard java

There is currently no support for anything other than maven. You might be able
to get away with finding the correct version and importing it with the gradle
interface, or a `.jar` but this method is un-tested

If you are going to do this from a `.jar` or jars the correct ones will be located in
`target/dependency-jars`


### Raspberry Pi models supported
* Model B+

Any other model will most likely work, but we have not tested this and cannot
guarantee success


## How it works

To makes things less complicated we programmed the interface that actually talks
to the raspberry pi in python but made it callable with java.

The python code works by setting the `MS1`, `MS2`, `MS3`, and `DIR`  to either a true or false
statement. The true and false statements represents the following

| Step Type | MS1 | MS2 | MS3 |
| --------- | --- | --- | --- |
| Full Step | False | False | False |
| Half Step | True | False | False |
| Quarter Step | False | True | False |
| Eighth Step | True | True | False |
| Sixteenth Step | True | True | True |

| Direction | DIR Pin |
| --------- | ------- |
| Clockwise |  True   |
| Counter-Clockwise| False |

Then once all of these pins have been deactivated or activated the application then
needs to send a burst of signals to the `STEP` pin which will let the motor controller
know when to spin the stepper motor a step depending on what's selected. The `step_delay`
is how often the signal will be sent we recommend `0.005` anything less than that for us
seems to be unstable and anything more than that isn't as fast.


## How to use it

After importing all the appropriate jar files you should declare a variable to a new
motor class like this

`Motor varName = new Motor();`

after this you can call the rotate function which will rotate the stepper motor until
a button has been pressed (the user selects the button pin)

Example
```java
Motor motor = new Motor();
motor.rotate(true, false, false, false, "21", "16", "19", "20", "26", "0.005", "24");
```

These are the parameters that are needed
```java
(boolean clockwise, boolean ms1, boolean ms2, boolean ms3, String STEP, String MS1, String MS2, String MS3, String DIR, String step_delay, String btn_pin)
```


