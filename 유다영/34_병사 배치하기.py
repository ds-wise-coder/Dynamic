n = int(input())
arr = list(map(int, input().split()))

# 순서를 뒤집어 "Longest Decreasing Subsequence" 문제로 변환
arr.reverse()

# dp를 위한 1차원 dp table 초기화
dp = [1] * n

# LIS 알고리즘 수행
for i in range(1, n):
    for j in range(0, i):
        if arr[j] < arr[i]:
            dp[i] = max(dp[i], dp[j] + 1)

# 열외해야 하는 최소 병사수 출력
print(n - max(dp))
