from __future__ import annotations
import os.path

def get_input_txt() -> List[str]:
    input_file = os.path.join(os.path.dirname(__file__), "input")
    with open(input_file, "r") as f:
        return f.readlines()

def part_one():
    lines = get_input_txt()

    count = 0

    #This is definitley not as "smart" as it could be
    for line in lines:
        #line = 7-50,8-33

        #pair1 = 7-50, pair2 = 8-33
        pair1, pair2 = line.split(",")

        #pair1_min = 7, pair2_max = 50
        pair1_min, pair1_max = pair1.split("-")
        pair2_min, pair2_max = pair2.split("-")

        #while this less code, I don't think it is really more readable
        #line = line.replace('-', ',')
        #pair1_min, pair1_max, pair2_min, pair2_max = line.split(',')

        #This is proabably too complicated
        if pair1_min <= pair2_min and pair1_max >= pair2_max:
            count += 1
        elif pair2_min <= pair1_min and pair2_max >= pair1_max:
            count += 1

    #509
    print(count)

if __name__ == "__main__":
    part_one()