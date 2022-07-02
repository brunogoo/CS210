import datetime, os, signal, subprocess, sys, time, unittest

def run(command, stdin = None, timeout = 30):
    """
    Runs the specified command using specified standard input (if any) and
    returns the output on success. If the command doesn't return within the
    specified time (in seconds), "__TIMEOUT__" is returned.
    """

    start = datetime.datetime.now()
    process = subprocess.Popen(command.split(),
                               stdin = subprocess.PIPE, 
                               stdout = subprocess.PIPE,
                               stderr = subprocess.STDOUT)
    if not stdin is None:
        process.stdin.write(bytes(stdin, 'utf-8'))
    process.stdin.close()
    while process.poll() is None:
        time.sleep(0.1)
        now = datetime.datetime.now()
        if (now - start).seconds > timeout:
            os.kill(process.pid, signal.SIGKILL)
            os.waitpid(-1, os.WNOHANG)
            return "__TIMEOUT__"
    result = process.stdout.read().decode("utf-8")
    process.stdout.close()
    return result

class Problem1(unittest.TestCase):
    
    def test1(self):
        command = """java Die 5 3 3"""
        sought = """*   *
  *  
*   *
false
true
"""
        got = run(command)
        self.assertNotEqual(got, "__TIMEOUT__")
        self.assertEqual(got, sought)

class Problem2(unittest.TestCase):
    
    def test1(self):
        command = "java PhoneNumber"
        sought = """(609) 258-4455
(609) 876-5309
(609) 003-5309
(215) 876-5309
(609) 876-5309
true
false
true
true
"""
        got = run(command)
        self.assertNotEqual(got, "__TIMEOUT__")
        self.assertEqual(got, sought)

class Problem3(unittest.TestCase):
    
    def test1(self):
        command = "java Location 5 40.6769 117.2319"
        sought = """The Great Wall of China (China) (40.6769, 117.2319)
Petra (Jordan) (30.3286, 35.4419)
The Colosseum (Italy) (41.8902, 12.4923)
Chichen Itza (Mexico) (20.6829, -88.5686)
Machu Picchu (Peru) (-13.1633, -72.5456)
Taj Mahal (India) (27.175, 78.0419)
Christ the Redeemer (Brazil) (22.9519, -43.2106)
3868.964067791193
false
"""
        got = run(command)
        self.assertNotEqual(got, "__TIMEOUT__")
        self.assertEqual(got, sought)

class Problem4(unittest.TestCase):
    
    def test1(self):
        command = "java Point3D"
        sought = """(-3.0, 1.0, 6.0), distance to origin = 6.782329983125268
(0.0, 5.0, 8.0), distance to origin = 9.433981132056603
(-5.0, -7.0, -3.0), distance to origin = 9.1104335791443
"""
        got = run(command, "3 -3 1 6 0 5 8 -5 -7 -3")
        self.assertNotEqual(got, "__TIMEOUT__")
        self.assertEqual(got, sought)

class Problem5(unittest.TestCase):
    
    def test1(self):
        command = "java Rational 10"
        sought = """1023/512
"""
        got = run(command)
        self.assertNotEqual(got, "__TIMEOUT__")
        self.assertEqual(got, sought)

if __name__ == "__main__":
    unittest.main()
