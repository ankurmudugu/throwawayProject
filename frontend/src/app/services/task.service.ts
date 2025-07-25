import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Task {
  id: string,
  title: string,
  completed: boolean,
  description: string,
}

@Injectable({
  providedIn: 'root'
})
export class TaskService {


  private allUrl = 'http://localhost:8080/api/tasks'
  private completedUrl = 'http://localhost:8080/api/tasks/completed'
  private aiUrl = 'http://localhost:8080/api/ai/assist'

  constructor(private http: HttpClient) { }

  getOpenTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(this.completedUrl);
  }

  getAllTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(this.allUrl);
  }

  addTask(task: Omit<Task, 'id'>): Observable<Task> {
    return this.http.post<Task>(this.allUrl, task);
  }

  aiAssist(task: Omit<Task, 'id'>): Observable<string> {
    return this.http.post(this.aiUrl, task, { responseType: 'text' });
  }
}
