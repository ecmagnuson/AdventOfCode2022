with open("input.txt", "r") as f:
    lines = f.readlines()

temp = 0
elf_sum = 0

for line in lines:
    line = line.strip("\n")
    if line == "":
        if temp > elf_sum:
            elf_sum = temp
        temp = 0
        continue
    temp += int(line)

print(elf_sum)