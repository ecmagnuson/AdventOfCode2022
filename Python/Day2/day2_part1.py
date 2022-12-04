from __future__ import annotations
import os.path


def get_input_txt() -> List[str]:
    rpsfile = os.path.join(os.path.dirname(__file__), 'input.txt')
    with open(rpsfile, "r") as f:
        return f.readlines()


def part_one():

    my_choice_points = {"R": 1, "P": 2, "S": 3}

    beating_conditions = {"R": "S", "P": "R", "S": "P"}

    #converting me and opponent to typical R,P,S
    convert = {"A": "R", "B": "P", "C": "S", 
               "X":"R", "Y": "P", "Z": "S"}

    games = get_input_txt()

    score = 0

    #This is not very good probably
    for game in games:
        game = game.replace(" ", "")
        game = game.replace(game[0], convert[game[0]])
        game = game.replace(game[1], convert[game[1]])

        them = game[0]
        me = game[1]

        #I pick R, P, or S
        score += my_choice_points[me]
        
        #tie
        if them == me:
            score += 3

        #if my key's value is their choice then I win!
        elif beating_conditions[me] == them:
            score += 6

    print(score) 

if __name__ == '__main__':
    part_one()