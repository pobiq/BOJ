def solution(wallpaper):
    
    rows = len(wallpaper)
    cols = len(wallpaper[0])
    
    lux = rows - 1
    luy = cols - 1
    rdx = 0
    rdy = 0
    
    for row in range(rows):
        for col in range(cols):
            if wallpaper[row][col] == "#":
                if lux > row:
                    lux = row
                
                if luy > col:
                    luy = col
                
                if rdx < row:
                    rdx = row
                    
                if rdy < col:
                    rdy = col
    
    rdx += 1
    rdy += 1
    
    answer = [lux, luy, rdx, rdy]
    return answer