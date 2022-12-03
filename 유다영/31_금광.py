# DP
# 1. 정의 f(i,j):=i,j칸에 왔을 때 금 개수 최댓값
# 2. 구하는 값: 최댓값.. f(n, m)?
# 3. 초기값: f(1,1)
# 4. 점화식: f(i,j)=max(f(i-1,j-1)+f(i,j-1), f(i+1, j-1))+f(i, j)

n, m = map(int, input().split())
array = list(map(int, input().split()))

dp = []
idx = 0

for i in range(n):
    dp.append(array[idx:idx + m])
    idx += m

for j in range(1, m):  # 2번째 열부터 마지막열까지
    for i in range(n):  # 1번째 행부터 마지막행까지
        # 왼쪽에서 오는 경우
        left = dp[i][j - 1]
        # 왼쪽 위에서 오는 경우
        if i == 0:
            left_up = 0
        else:
            left_up = dp[i - 1][j - 1]
        # 왼쪽 아래에서 오는 경우
        if i == n - 1:
            left_down = 0  # 아래쪽 벽 넘으면 0

        else:
            left_down = dp[i + 1][j - 1]
        dp[i][j] = dp[i][j] + max(left_up, left, left_down)
res = 0
for i in range(n):
    res = max(res, dp[i][m - 1])
print(res)
