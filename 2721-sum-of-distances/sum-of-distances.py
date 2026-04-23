class Solution:
    def distance(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [0] * n  # Initialize result array with zeros

        # First pass: left to right
        # freq: stores count of each number encountered
        # sum_indices: stores sum of indices for each number encountered
        freq = {}
        sum_indices = {}

        for i in range(n):
            num = nums[i]
            if num in freq:
                count = freq[num]
                prev_sum = sum_indices[num]

                # Sum of distances to elements on the left:
                # (i - j1) + (i - j2) + ... = i * count - (j1 + j2 + ...)
                res[i] += i * count - prev_sum

                freq[num] += 1
                sum_indices[num] += i
            else:
                # First time seeing this number
                freq[num] = 1
                sum_indices[num] = i

        # Clear maps for the second pass
        freq.clear()
        sum_indices.clear()

        # Second pass: right to left
        for i in range(n - 1, -1, -1): # Iterate from n-1 down to 0
            num = nums[i]
            if num in freq:
                count = freq[num]
                next_sum = sum_indices[num]

                # Sum of distances to elements on the right:
                # (j1 - i) + (j2 - i) + ... = (j1 + j2 + ...) - i * count
                res[i] += next_sum - i * count

                freq[num] += 1
                sum_indices[num] += i
            else:
                # First time seeing this number from the right
                freq[num] = 1
                sum_indices[num] = i
                
        return res