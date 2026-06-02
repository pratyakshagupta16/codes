class Solution:
    def partition(self, head, x):
        small = ListNode(0)
        large = ListNode(0)

        small_tail = small
        large_tail = large

        while head:
            if head.val < x:
                small_tail.next = head
                small_tail = small_tail.next
            else:
                large_tail.next = head
                large_tail = large_tail.next

            head = head.next

        large_tail.next = None
        small_tail.next = large.next

        return small.next