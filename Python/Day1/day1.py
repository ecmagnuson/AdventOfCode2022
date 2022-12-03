from __future__ import annotations
import os.path

def input() -> List[str]:
    f = os.path.join(os.path.dirname(__file__), 'input.txt')
    with open(f, "r") as f:
        return f.readlines()

def part_one():
    temp = 0
    elf_sum = 0
    lines = input()
    for line in lines:
        line = line.strip("\n")
        if line == "":
            if temp > elf_sum:
                elf_sum = temp
            temp = 0
            continue
        temp += int(line)
    print(elf_sum)

def part_two():
    #find the elfs with the top three most calories and sum them up
    temp_elf_sum = 0
    elf_calorie_sum_list = []
    lines = input()
    for line in lines:
        line = line.strip("\n")
        if line == "":
            elf_calorie_sum_list.append(temp_elf_sum)
            temp_elf_sum = 0
            continue
        temp_elf_sum += int(line)
    
    sorted_elf_list = sorted(elf_calorie_sum_list)

    print(sum(sorted_elf_list[ len(sorted_elf_list) - 3 : len(sorted_elf_list)]))

def main():
    part_one()
    part_two()

main()