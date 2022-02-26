##THIS IS FOR DEBUGGING IGNORE THIS

import os
os.system("rm -r target && mvn package")

import time
time.sleep(2)
os.system("zip -r A4988Driver.zip target")


