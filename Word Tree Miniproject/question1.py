#!/usr/bin/env python
# coding: utf-8

# In[7]:


class BTNode2:
    def __init__(self,d,l,r):
        self.data = d
        self.left = l
        self.right = r
        self.mult = 1
          
    # prints the node and all its children in a string
    def __str__(self):  
        st = "(" + str(self.data) + ", " + str(self.mult) +") -> ["
        if self.left != None:
            st += str(self.left)
        else: st += "None"
        if self.right != None:
            st += ", "+str(self.right)
        else: st += ", None"
        return st + "]"

class BST2:
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

    # adds the data d in the tree, increases the size by 1
    # and returns None
    def add(self, d):   
        # TODO: needs to be implemented
        self.root = self._addNodeRec(self.root,d)
        return None
        
    def _addNodeRec(self, ptr, d):
        if ptr == None:
            self.size += 1
            return BTNode2(d,None,None)
        if d == ptr.data:
            ptr.mult += 1
            self.size += 1
            return ptr
        if d < ptr.data:
            ptr.left = self._addNodeRec(ptr.left,d)
        else:
            ptr.right = self._addNodeRec(ptr.right,d)        
        return ptr
    
    #Searches for a node with a specific value
    def _searchNodeRec(self, ptr, d):
        if ptr == None:
            return 0
        if d == ptr.data:
            return ptr.mult
        if d < ptr.data:
            return self._searchNodeRec(ptr.left,d)
        else:
            return self._searchNodeRec(ptr.right,d)

    # returns the number of times that d is stored in the tree
    def count(self, d):    
        # TODO: needs to be implemented
        return self._searchNodeRec(self.root, d)
    
    # removes one occurrence of d from the tree and returns None
    # if d does not occur in the tree then it returns without changing the tree
    # it updates the size of the tree accordingly
    def remove(self,d):    
        # TODO: needs to be implemented
        self.root = self._removeNodeRec(self.root,d)
        return None
        
    def _removeNodeRec(self, ptr, d):
        if ptr == None:
            return None
        if d < ptr.data:
            ptr.left = self._removeNodeRec(ptr.left,d)
            return ptr
        elif d == ptr.data and ptr.mult > 1:
            ptr.mult -= 1
            self.size -= 1
            return ptr
        elif d > ptr.data:
            ptr.right = self._removeNodeRec(ptr.right,d)
            return ptr
        self.size -= 1
        if ptr.left == ptr.right == None:
            return None
        elif ptr.left == None or ptr.right == None:
            if ptr.left != None:
                return ptr.left
            else:
                return ptr.right
        [minNode, minRemoved] = self._removeMinNode(ptr.right)
        minNode.left = ptr.left
        minNode.right = minRemoved
        return minNode
    
    def _removeMinNode(self, ptr):
        if ptr.left == None:
            return [ptr, ptr.right]
        [minNode, minRemoved] = self._removeMinNode(ptr.left)
        ptr.left = minRemoved
        return [minNode,ptr]