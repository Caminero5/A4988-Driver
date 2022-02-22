import sys
pinNum = int(sys.argv[1])
BTNPin = int(sys.argv[2])
step_Delay = float(sys.argv[3])

import RPi.GPIO as GPIO
GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)

GPIO.setup(BTNPin, GPIO.IN, pull_up_down=GPIO.PUD_UP)
GPIO.setup(pinNum, GPIO.OUT)

from time import sleep
while True:
    try:
        GPIO.output(pinNum,GPIO.HIGH)
        sleep(step_Delay)
        GPIO.output(pinNum,GPIO.LOW)
        input_state = GPIO.input(BTNPin)
        if input_state == False:
            break
    finally:
        GPIO.output(pinNum,GPIO.LOW)

