#!/usr/bin/env python
# coding: utf-8

# In[2]:


class WTNode:
    def __init__(self,d,l,r,n):
        self.data = d
        self.left = l
        self.right = r
        self.next = n
        self.mult = 0
          
    # prints the node and all its children in a string
    def __str__(self):  
        st = "("+str(self.data)+", "+str(self.mult)+") -> ["
        if self.left != None:
            st += str(self.left)
        else: st += "None"
        if self.next != None:
            st += ", "+str(self.next)
        else: st += ", None"
        if self.right != None:
            st += ", "+str(self.right)
        else: st += ", None"
        return st + "]"
    
class WordTree:
    def __init__(self):
        self.root = None
        self.size = 0
        
    def __str__(self):
        return str(self.root)

    # returns True is the tree is empty, otherwise False    
    def isEmpty(self):
        if self.root == None or self.size == 0:
            return True
        return False

    # adds the string st in the tree, increases the size by 1
    def add(self,st):
        if st == "":
            return None
        if self.root == None:
            self.root = WTNode(st[0], None, None, None)
            ptr = self.root
            for pos in range(1,len(st)):
                ptr.next = WTNode(st[pos], None, None, None)
                ptr = ptr.next
        ptr = self.root
        pos = 0 
        while pos < len(st):
            while True:
                if st[pos] == ptr.data:
                    if pos == len(st)-1:
                        ptr.mult += 1
                    elif ptr.next == None:
                        ptr.next = WTNode(st[pos+1], None, None, None)
                        ptr = ptr.next
                    else:
                        ptr = ptr.next
                    pos += 1
                elif st[pos] < ptr.data:
                    if ptr.left == None:
                        ptr.left = WTNode(st[pos], None, None, None)
                    ptr = ptr.left
                else:
                    if ptr.right == None:
                        ptr.right = WTNode(st[pos], None, None, None)
                    ptr = ptr.right
                break
        self.size += 1

    # returns the number of times that string st is stored in the tree
    def count(self, st):
        if self.root == None:
            return 0
        if st == "":
            return None
        ptr = self.root
        i = 0
        while ptr != None:
            if st[i] == ptr.data and i == len(st)-1:
                return ptr.mult
            if st[i] == ptr.data:
                i += 1
                ptr = ptr.next
            elif st[i] < ptr.data:
                ptr = ptr.left
            else:
                ptr = ptr.right
        return 0
    
    # removes one occurrence of string st from the tree
    # by lowering its multiplicity
    def remove(self,st):    
        if self.count(st) == 0 or self.count(st) == None:
            return 
        ptr = self.root
        i = 0
        while True:
            if st[i] == ptr.data and i == len(st)-1:
                ptr.mult -= 1
                self.size -= 1
                return
            if st[i] == ptr.data:
                i += 1
                ptr = ptr.next
            elif st[i] < ptr.data:
                ptr = ptr.left
            else:
                ptr = ptr.right