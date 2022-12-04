from __future__ import annotations
import os.path

def get_input_txt() -> List[str]:
    rpsfile = os.path.join(os.path.dirname(__file__), "input")
    with open(rpsfile, "r") as f:
        return f.readlines()

#This is totally nonsense. It is way overcomplicating things
#to make them objects, but I thought it would be interesting
#way to practice OOP thinking

#each Pair object has its beginning and end attribute
class Pair:

    def __init__(self, pair: str):
        self.elf1 : str
        self.elf2 : str
        self.elf1 , self.elf2 = pair.split(",")

    def __repr__(self):
        return f"{self.elf1} {self.elf2}"

    def _contains(self):
        self.elf1
        self.elf2
        count = 0

        return count


def main():
    pairs : List[str] = get_input_txt()
    
    pair: str
    for pair in pairs:
        pair = Pair(pair)

        pair._contains()

if __name__ == "__main__":
    main()