with open("input.txt", "r") as f:
    lines = f.readlines()

#find the elfs with the top three most calories and sum them up

temp_elf_sum = 0
elf_calorie_sum_list = []

for line in lines:
    line = line.strip("\n")
    if line == "":
        elf_calorie_sum_list.append(temp_elf_sum)
        temp_elf_sum = 0
        continue
    temp_elf_sum += int(line)

print(sum(sorted_elf_list[ len(sorted_elf_list) - 3 : len(sorted_elf_list)]))