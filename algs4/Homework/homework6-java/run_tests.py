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
        command = """java IndirectSort"""
        sought = """A C D E E E E I I I I L M N N N O O P R R R S S T T T X
"""
        got = run(command, "I N D I R E C T I N S E R T I O N S O R T E X A M P L E")
        self.assertNotEqual(got, "__TIMEOUT__")
        self.assertEqual(got, sought)

class Problem2(unittest.TestCase):
    
    def test1(self):
        command = "java MergeQueues"
        sought = """A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 
"""
        got = run(command)
        self.assertNotEqual(got, "__TIMEOUT__")
        self.assertEqual(got, sought)

class Problem3(unittest.TestCase):
    
    def test1(self):
        command = "java ShannonEntropy 1000 5"
        sought = """H = 0.23
"""
        got = run(command)
        self.assertNotEqual(got, "__TIMEOUT__")
        self.assertEqual(got, sought)

    def test2(self):
        command = "java ShannonEntropy 1000 41"
        sought = """H = 0.54
"""
        got = run(command)
        self.assertNotEqual(got, "__TIMEOUT__")
        self.assertEqual(got, sought)
        
class Problem4(unittest.TestCase):
    
    def test1(self):
        command = "java CertifyHeap"
        sought = """false
"""
        got = run(command, "0 T H R P S O A E I N G")
        self.assertNotEqual(got, "__TIMEOUT__")
        self.assertEqual(got, sought)
        
    def test2(self):
        command = "java CertifyHeap"
        sought = """true
"""
        got = run(command, "0 T S R P N O A E I H G")
        self.assertNotEqual(got, "__TIMEOUT__")
        self.assertEqual(got, sought)

class Problem5(unittest.TestCase):
    
    def test1(self):
        command = "java Ramanujan 40000"
        sought = """1729 = 1^3 + 12^3 = 9^3 + 10^3
4104 = 2^3 + 16^3 = 9^3 + 15^3
13832 = 18^3 + 20^3 = 2^3 + 24^3
20683 = 19^3 + 24^3 = 10^3 + 27^3
32832 = 18^3 + 30^3 = 4^3 + 32^3
39312 = 15^3 + 33^3 = 2^3 + 34^3
"""
        got = run(command)
        self.assertNotEqual(got, "__TIMEOUT__")
        self.assertEqual(sorted(got), sorted(sought))

if __name__ == "__main__":
    unittest.main()
