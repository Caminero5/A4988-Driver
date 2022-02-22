import sys
pinNum = sys.argv[1]

import RPi.GPIO as GPIO
GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)
GPIO.setup(int(pinNum), GPIO.OUT)

GPIO.output(int(pinNum),GPIO.HIGH)
