from typing import List
import math

class Easy:

    # O(N) runtime and O(N) space
    def two_sum(self, nums: List[int], target: int) -> List[int]:
        solution = []
        hashmap = {}
        for i in range(len(nums)):
            hashmap[nums[i]] = i

        for i in range(len(nums)):
            difference = math.fabs(nums[i] - target)
            if difference in hashmap:
                solution = [i, hashmap[difference]]
                return solution
                
        return solution