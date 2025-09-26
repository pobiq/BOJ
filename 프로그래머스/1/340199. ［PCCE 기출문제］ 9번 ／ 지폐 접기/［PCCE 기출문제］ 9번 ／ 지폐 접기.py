def solution(wallet, bill):
    answer = 0
    
    while True:
        
        bill_max = max(bill)
        bill_min = min(bill)
        
        wallet_max = max(wallet)
        wallet_min = min(wallet)
        
        if bill_min <= wallet_min and bill_max <= wallet_max:
            break
        
        if bill[0] > bill[1]:
            bill[0] = bill[0] // 2
        else :
            bill[1] = bill[1] // 2
        answer += 1
        
        print(bill)
    
    return answer