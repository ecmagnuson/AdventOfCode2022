from __future__ import annotations
import os.path
import string


def get_input_txt() -> str:
    rpsfile = os.path.join(os.path.dirname(__file__), "input")
    with open(rpsfile, "r") as f:
        return f.read()

#This is definitley overcomplicated..
def part_two():

    #first value is an empty whitespace so that the value alligns with its priorty
    #in essence, making this string index starting at 1 instead of 0 
    priorities = " " + string.ascii_lowercase + string.ascii_uppercase

    span = 3
    lines = get_input_txt().split("\n")
    grouped_lines = [" ".join(lines[i:i+span]) for i in range(0, len(lines), span)]

    priority_sum = 0

    for line in grouped_lines:
        sacks = line.split(" ")
        try:
            sack1 = sacks[0]
            sack2 = sacks[1]
            sack3 = sacks[2]

        except IndexError as e:
            pass

        common_value = set(sack1) & set(sack2) & set(sack3)

        priority_sum += priorities.index(''.join(common_value))
    
    print(priority_sum)

if __name__ == "__main__":
    part_two()