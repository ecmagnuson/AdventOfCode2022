from __future__ import annotations
import os.path

def get_input_txt() -> List[str]:
    input_file = os.path.join(os.path.dirname(__file__), "input")
    with open(input_file, "r") as f:
        return f.readlines()

def part_two():
    lines = get_input_txt()

    """ lines = ["2-4,6-8", # no overlap
             "2-3,4-5", # no overlap
             "5-7,7-9", # 7 overlap
             "2-8,3-7", # 3,4,5,6,7 overlap
             "6-6,4-6",
             "2-6,4-8"] """

    count = 0

    #This is definitley not as "smart" as it could be
    for line in lines:

        #pair1 = 7-50, pair2 = 8-33
        pair1, pair2 = line.split(",")

        

        #pair1_min = 7, pair2_max = 50
        pair1_min, pair1_max = pair1.split("-")
        pair2_min, pair2_max = pair2.split("-")

        range1 = range(int(pair1_min),int(pair1_max) + 1)
        range2 = range(int(pair2_min),int(pair2_max) + 1)

        r1s = set(range1)
        
        intersect = r1s.intersection(range2)

        if len(intersect) > 0:
            count += 1
        
    #870
    print(count)

if __name__ == "__main__":
    part_two()