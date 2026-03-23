import http from 'k6/http';
import { check } from 'k6';

export const options = {
  stages: [
    { duration: '20s', target: 200 },
    { duration: '1m30s', target: 500 },
    { duration: '30s', target: 0 },
  ],
  insecureSkipTLSVerify: true,
};

export default function () {
  const res = http.get('https://snowflake.dev.local/next-id');
  check(res, {
    'status is 200': (r) => r.status === 200,
  });
}
