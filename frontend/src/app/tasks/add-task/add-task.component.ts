import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TaskService } from 'src/app/services/task.service';

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})
export class AddTaskComponent implements OnInit {

  taskTitle: string = "";
  taskDescription: string = "";

  constructor(private taskService: TaskService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }
  onSubmit() {
    const newTask = {
      title: this.taskTitle,
      description: this.taskDescription,
      completed: false
    };

    this.taskService.addTask(newTask).subscribe({
      next: (created) => {
        console.log('Task created:', created);
        // navigate back or reset form
        this.router.navigate(['/overview']);
      },
      error: (err) => console.error('Error creating task', err)
    });
  }


}
