import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MyAppSharedModule } from 'app/shared/shared.module';
import { MovieComponent } from './movie.component';
import { MovieDetailComponent } from './movie-detail.component';
import { MovieUpdateComponent } from './movie-update.component';
import { MovieDeleteDialogComponent } from './movie-delete-dialog.component';
import { movieRoute } from './movie.route';

@NgModule({
  imports: [MyAppSharedModule, RouterModule.forChild(movieRoute)],
  declarations: [MovieComponent, MovieDetailComponent, MovieUpdateComponent, MovieDeleteDialogComponent],
  entryComponents: [MovieDeleteDialogComponent],
})
export class MyAppMovieModule {}
