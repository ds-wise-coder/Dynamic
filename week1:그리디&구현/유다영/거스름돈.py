# 거스름돈 500, 100, 50, 10원
# 손님에게 거슬러주어야 하는 돈 N원
# 거슬러 주어야 할 동전의 최소 개수?

N = int(input())

coins = [500, 100, 50, 10]
coin_cnt = 0
for coin in coins:
    coin_cnt += N // coin
    N = N % coin
print(coin_cnt)
