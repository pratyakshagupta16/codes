# Function to join given bound_by and tag
def join_middle(bound_by, tag_name):
    return bound_by[0:len(bound_by)//2] + tag_name + bound_by[len(bound_by)//2:]