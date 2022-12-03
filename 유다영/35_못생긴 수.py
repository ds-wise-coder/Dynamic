# 못생긴 수는 2, 3, 5만을 약수로 가진 합성수

n = int(input())

# 2,3,5부터 시작
two, three, five = 2, 3, 5
# 인덱스 하나씩 증가
cnt2, cnt3, cnt5 = 0, 0, 0

# dp 테이블 초기화
dp = [0] * n
dp[0] = 1

for i in range(1, n):
    dp[i] = min(two, three, five)
    if dp[i] == two:
        cnt2 += 1  # 인덱스 증가
        two = dp[cnt2] * 2  # 해당 인덱스값 *2로 업데이트
    if dp[i] == three:
        cnt3 += 1  # 인덱스 증가
        three = dp[cnt3] * 2  # 해당 인덱스값 *3로 업데이트
    if dp[i] == five:
        cnt5 += 1  # 인덱스 증가
        five = dp[cnt5] * 2  # 해당 인덱스값 *5 업데이트
print(dp[n - 1])
