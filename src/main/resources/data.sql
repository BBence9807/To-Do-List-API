INSERT INTO task_type (id, tt_name) VALUES (1, 'SHOPPING');
INSERT INTO task_type (id, tt_name) VALUES (2, 'WORKOUT');
INSERT INTO task_type (id, tt_name) VALUES (3, 'READ');

INSERT INTO task (id, t_completed,t_description,t_due_date,t_title,t_task_type_id) VALUES (1, FALSE , 'Go shopping', NOW(),'Shopping Milk',1);
INSERT INTO task (id, t_completed,t_description,t_due_date,t_title,t_task_type_id) VALUES (2, FALSE , 'Go to gym', NOW(),'Workout well',2);
INSERT INTO task (id, t_completed,t_description,t_due_date,t_title,t_task_type_id) VALUES (3, FALSE , 'Read a new book', NOW(),'Read and relax',3);
