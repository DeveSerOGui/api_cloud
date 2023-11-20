import { AfterViewInit, Component, OnDestroy, OnInit } from '@angular/core';
import { PostService } from '../../services/post.service';
import { Post } from '../../model/posts.model';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css'],
})
export class PostComponent implements OnInit {
  posts: Post[] = [];

  constructor(private postService: PostService) {

  }

  ngOnInit(): void {
    this.postService.getPosts().subscribe(response => {
      this.posts = response;
      console.log(response)
    });
  }

  //CICLO DO VIDA DO COMPONENTE DO ANGULAR
  /*
  ngBeforeViewInit(): void {
  }
  ngAfterViewInit(): void {
  }
  ngChanges(): void {
  }
  ngOnDestroy(): void {
  }
  */
}
