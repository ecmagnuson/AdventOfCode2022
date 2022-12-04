from __future__ import annotations
import os.path
import string

def get_input_txt() -> List[str]:
    rpsfile = os.path.join(os.path.dirname(__file__), 'input.txt')
    with open(rpsfile, "r") as f:
        return f.readlines()

def part_one():
    lines = get_input_txt()

    #first value is an empty whitespace so that the value alligns with its priorty
    #in essence, making this string index starting at 1 instead of 0 
    priorities = " " + string.ascii_lowercase + string.ascii_uppercase

    priority_sum = 0

    for line in lines:
         #split the line in half evenly
        first_compartment = line[ : len(line)//2]
        second_compartment = line[len(line)//2 : ]

        #find the value common between the two
        #my immediate thought on this but this is probably naive
        #for char in first_compartment:
        #    if char in second_compartment:
        #        common_value = char

        #set intersection as well works
        common_value = ''.join(set(first_compartment).intersection(second_compartment))
        
        priority_sum += priorities.index(common_value)

    print(priority_sum)

if __name__ == "__main__":
    part_one()