import unittest
from easy import Easy

class easy_test(unittest.TestCase):
    solution = None

    def setUp(self):
        self.solution = Easy()

    def test_two_sum_case1(self):
        nums = [2, 7, 11, 15]
        target = 9

        self.assertEqual(self.solution.two_sum(nums, target), [0, 1])

    def test_two_sum_case2(self):
        nums = [2, 7, 11, 15]
        target = 6

        self.assertEqual(self.solution.two_sum(nums, target), [])
    
    def test_two_sum_case3(self):
        nums = []
        target = 10

        self.assertEqual(self.solution.two_sum(nums, target), [])

    def test_two_sum_case4(self):
        nums = [3,2,4]
        target = 6

        self.assertEqual(self.solution.two_sum(nums, target), [1,2])

if __name__ == '__main__':
    unittest.main()
    print ("All tests passted")