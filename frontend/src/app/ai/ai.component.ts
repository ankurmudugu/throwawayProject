import { Component, OnInit } from '@angular/core';
import { TaskService, Task } from '../services/task.service';


@Component({
  selector: 'app-ai',
  templateUrl: './ai.component.html',
  styleUrls: ['./ai.component.css']
})
export class AiComponent implements OnInit {

  tasks: Task[] = [];
  selectedResponse: string = '';
  loading: boolean = false;

  constructor(private taskService: TaskService) { }

  ngOnInit(): void {
    this.taskService.getOpenTasks().subscribe({
      next: (data) => {
        this.tasks = data;
      },
      error: (err) => {
        console.error('Error loading tasks', err);
      }
    });
  }

  getAiHelp(task: Task) {
    this.loading = true;
    this.selectedResponse = '';
    this.taskService.aiAssist({
      title: task.title,
      description: task.description,
      completed: task.completed
    }).subscribe({
      next: (response: string) => {
        this.selectedResponse = response;
        this.loading = false;
      },
      error: (err) => {
        console.error('AI Assist error', err);
        this.selectedResponse = 'Error getting AI assistance.';
        this.loading = false;
      }
    });
  }


}
