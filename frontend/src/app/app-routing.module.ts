import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TaskListComponent } from './tasks/task-list/task-list.component';
import { TaskHistoryComponent } from './tasks/task-history/task-history.component';
import { AddTaskComponent } from './tasks/add-task/add-task.component';
import { LayoutComponent } from './layout/layout.component';
import { AiComponent } from './ai/ai.component';
const routes: Routes = [
    {
    path: '',
    component: LayoutComponent,
    children: [
      { path: '', redirectTo: 'overview', pathMatch: 'full' },
      { path: 'overview', component: TaskListComponent },
      { path: 'history', component: TaskHistoryComponent },
      { path: 'create', component: AddTaskComponent },
      { path: 'ai', component: AiComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
