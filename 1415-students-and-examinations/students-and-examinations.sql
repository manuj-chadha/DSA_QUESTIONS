-- Write your PostgreSQL query statement below
SELECT stu.student_id, stu.student_name, subjects.subject_name, COUNT(e.student_id) AS attended_exams FROM students stu CROSS JOIN subjects
LEFT JOIN examinations e ON e.student_id=stu.student_id AND e.subject_name=subjects.subject_name GROUP BY stu.student_id, subjects.subject_name, stu.student_name;