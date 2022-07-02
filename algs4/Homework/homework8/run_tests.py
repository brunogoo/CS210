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
        command = "java GraphProperties data/tinyG.txt"
        sought = """Diameter = 7
Radius   = 4
Centers  = 0 4 6 
"""
        got = run(command)
        self.assertNotEqual(got, "__TIMEOUT__")
        self.assertEqual(got, sought)

class Problem2(unittest.TestCase):
    
    def test1(self):
        command = "java Degrees data/tinyDG.txt"
        sought = """Sources = 7 
Sinks   = 1 
Is Map  = false
"""
        got = run(command)
        self.assertNotEqual(got, "__TIMEOUT__")
        self.assertEqual(got, sought)

class Problem3(unittest.TestCase):
    
    def test1(self):
        command = "java EuclideanEdge 0 0 1 1 1 0 0 1"
        sought = """(0.0, 0.0)-(1.0, 1.0) 1.41421
(1.0, 0.0)-(0.0, 1.0) 1.41421
0
"""
        got = run(command)
        self.assertNotEqual(got, "__TIMEOUT__")
        self.assertEqual(got, sought)

class Problem4(unittest.TestCase):
    
    def test1(self):
        command = "java EuclideanEdgeWeightedGraph data/tinyEG.txt"
        sought = """(-2.99428874799, -4.81382481949)-(-3.50590184636, 2.70830491327) 7.53951
(1.79035963543, -4.7292107303)-(-3.50590184636, 2.70830491327) 9.13055
(-3.50590184636, 2.70830491327)-(3.88256645668, -1.23291312479) 8.37393
(-3.50590184636, 2.70830491327)-(2.95034889345, 4.14320098075) 6.61378
(-3.50590184636, 2.70830491327)-(-3.06299778289, -1.37765565012) 4.10990
(1.79035963543, -4.7292107303)-(2.95034889345, 4.14320098075) 8.94792
(3.88256645668, -1.23291312479)-(2.95034889345, 4.14320098075) 5.45634
(-0.972219535182, 0.144692907976)-(2.95034889345, 4.14320098075) 5.60130
(-3.24240294366, 3.94050921397)-(2.95034889345, 4.14320098075) 6.19607
(-2.99428874799, -4.81382481949)-(-3.24240294366, 3.94050921397) 8.75785
(-2.99428874799, -4.81382481949)-(-0.609246278064, -2.3300787821) 3.44346
(-2.99428874799, -4.81382481949)-(-0.972219535182, 0.144692907976) 5.35497
(-0.972219535182, 0.144692907976)-(-3.06299778289, -1.37765565012) 2.58629
(1.79035963543, -4.7292107303)-(-3.24240294366, 3.94050921397) 10.02461
(1.79035963543, -4.7292107303)-(-0.609246278064, -2.3300787821) 3.39322
(-2.99428874799, -4.81382481949)-(-1.34570880317, -2.97279434591) 2.47128
(-1.34570880317, -2.97279434591)-(3.88256645668, -1.23291312479) 5.51018
(-1.34570880317, -2.97279434591)-(-0.972219535182, 0.144692907976) 3.13978
(-1.34570880317, -2.97279434591)-(-3.06299778289, -1.37765565012) 2.34383
(3.88256645668, -1.23291312479)-(-3.06299778289, -1.37765565012) 6.94707
(-0.609246278064, -2.3300787821)-(-3.06299778289, -1.37765565012) 2.63211
"""
        got = run(command)
        self.assertNotEqual(got, "__TIMEOUT__")
        self.assertEqual(got, sought)
        
class Problem5(unittest.TestCase):
    
    def test1(self):
        command = "java EuclideanKruskalMST data/tinyEG.txt"
        sought = """(-1.34570880317, -2.97279434591)-(-3.06299778289, -1.37765565012) 2.34383
(-2.99428874799, -4.81382481949)-(-1.34570880317, -2.97279434591) 2.47128
(-0.972219535182, 0.144692907976)-(-3.06299778289, -1.37765565012) 2.58629
(-0.609246278064, -2.3300787821)-(-3.06299778289, -1.37765565012) 2.63211
(1.79035963543, -4.7292107303)-(-0.609246278064, -2.3300787821) 3.39322
(-3.50590184636, 2.70830491327)-(-3.06299778289, -1.37765565012) 4.10990
(3.88256645668, -1.23291312479)-(2.95034889345, 4.14320098075) 5.45634
(-1.34570880317, -2.97279434591)-(3.88256645668, -1.23291312479) 5.51018
(-3.24240294366, 3.94050921397)-(2.95034889345, 4.14320098075) 6.19607
34.69921
"""
        got = run(command)
        self.assertNotEqual(got, "__TIMEOUT__")
        self.assertEqual(got, sought)

if __name__ == "__main__":
    unittest.main()
