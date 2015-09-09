class Solution(object):
    """
    :type s: str
    :type words: List[str]
    :rtype: List[int]
    """
    def findSubstring(self, s, words):
        if s == None or len(s) == 0 or \
            words == None or len(words) == 0:
                return []
                
        result = []
        toFind = {}
        for str in words:
            if str in toFind:
                toFind[str] = toFind[str] + 1
            else:
                toFind[str] = 1
                
        wordLen = len(words[0])
        count   = len(words)
        
        for i in range(0, len(s)-wordLen*count+1, 1):
            found = {}
            for j in range(0, count, 1):
                k = i + j*wordLen
                subStr = s[k:k+wordLen]
                if subStr not in toFind:
                    break
                if subStr not in found:
                    found[subStr] = 1
                else:
                    found[subStr] = found[subStr] + 1
                if found[subStr] > toFind[subStr]:
                    break
            else:
                result.append(i)
        
        return result            