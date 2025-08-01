# Problem: 20. Valid Parentheses
def isValid(s):
        # Mapping of the the bracket pairs
        pairs = {')':'(','}':'{',']':'['}
        stack = []
        isValid = True
        for i in s:
            if i in "({[":
                stack.append(i)
            else:
                if not stack or stack.pop()!=pairs[i]: # Checks if the stack is empty or if the bracket that is popped matches the pair
                    isValid = False
                    break
        return isValid #returns valid if all pairs are matched
# To test the function
testdata = input("Enter a string of Brackets: ")
print(isValid(testdata))
