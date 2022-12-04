from __future__ import annotations
import os.path


def get_input_txt() -> List[str]:
    rpsfile = os.path.join(os.path.dirname(__file__), 'input.txt')
    with open(rpsfile, "r") as f:
        return f.readlines()


def part_two():
    """
    the second column says how the round needs to end: 
    X means you need to lose, 
    Y means you need to draw,
    Z means you need to win.
    """

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

        them = game[0]
        end_condition = game[1]

        #lose
        if end_condition == "X":
            #condition where they beat me
            me = beating_conditions[them]
        #draw
        elif end_condition == "Y":
            me = them
            score += 3
        #win
        elif end_condition == "Z":
            #This is overly complicated I think.
            #I wanted to find the beating key that would have a value that is their choice ("R", "P", "S")
            me = str(list(beating_conditions.keys())[list(beating_conditions.values()).index(them)])
            score += 6      
 
        #Add the points from my choice
        score += my_choice_points[me]

    
    #correct answer 13509
    print(score) 

if __name__ == '__main__':
    part_two()