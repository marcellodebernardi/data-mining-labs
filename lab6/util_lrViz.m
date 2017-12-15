function util_lrViz(lx,LX,w,data,labels,VIZ,thr)
Y = util_lrclass_2c(LX,w);
Y=Y>thr;
sfigure(1); clf;
if(nargin>5 && VIZ==2)
    imagesc(lx,lx,reshape(Y,numel(lx),numel(lx))); colorbar; axis xy; hold on; colormap jet; caxis([0,1]);
else
    contour(lx,lx,reshape(abs(Y-0.5),numel(lx),numel(lx))); axis xy; hold on; colormap jet; caxis([0,0.5]);
end
if(nargin>3)
    plot(data(labels==1,1),data(labels==1,2),'mx','linewidth',2.0);
    plot(data(labels==0,1),data(labels==0,2),'bo','linewidth',2.0);
end
 title('LR classification results');