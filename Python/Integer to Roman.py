class Solution(object):
    """
    :type num: int
    :rtype: str
    """
    def intToRoman(self, num):
        if num <= 0:
            return ""
        
        r = []
        nums    = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1];
        symbols = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"];
        
        index = 0
        while num > 0:
            times = num / nums[index]
            num -= times * nums[index]
            for i in range(times, 0, -1):
                r.append(symbols[index])
            index += 1
        
        return "".join(r)
